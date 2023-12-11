package de.acegen.templates.java.views

import de.acegen.extensions.CommonExtension

class QueuedView {

	extension CommonExtension

	def generate() '''
		«copyright»
		
		package de.acegen;
		
		import java.util.concurrent.ArrayBlockingQueue;
		import java.util.concurrent.BlockingQueue;
		
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		
		import io.dropwizard.lifecycle.Managed;
		
		public abstract class QueuedView implements Managed {
		
			private Thread thread;
			private final BlockingQueue<Runnable> queue;
			private boolean stop;
		
			static final Logger LOG = LoggerFactory.getLogger(QueuedView.class);
		
			public QueuedView() {
				super();
				queue = new ArrayBlockingQueue<>(20);
			}
			
			public void addToQueue(Runnable runnable) {
				queue.add(runnable);
			}
		
			@Override
			public void start() {
				thread = new Thread(() -> {
					LOG.info("started queued view");
					while (!stop || queue.size() > 0) {
						try {
							queue.take().run();
						} catch (InterruptedException e) {
							LOG.error("error in queued view", e);
						}
					}
				});
				thread.start();
			}
		
			@Override
			public void stop() {
				for (int i = 0; i < 3; i++) {
					LOG.info("stopping queued view...");
					if (!canStop()) {
						LOG.info("waiting for queued view to complete...");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							LOG.error("error when stopping queued view", e);
						}
					} else {
						break;
					}
				}
				LOG.info("queued view stopped");
			}
			
			protected abstract boolean canStop(); 
		
		}

		
		«sdg»
		
	'''

}
