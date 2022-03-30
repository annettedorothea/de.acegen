@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  acegen-standalone startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and ACEGEN_STANDALONE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\de.acegen.ide-1.0.0-SNAPSHOT.jar;%APP_HOME%\lib\de.acegen-1.0.0-SNAPSHOT.jar;%APP_HOME%\lib\org.eclipse.xtext.xbase.ide-2.26.0.jar;%APP_HOME%\lib\org.eclipse.xtext.ide-2.26.0.jar;%APP_HOME%\lib\org.eclipse.lsp4j-0.12.0.jar;%APP_HOME%\lib\org.eclipse.lsp4j.generator-0.12.0.jar;%APP_HOME%\lib\org.eclipse.lsp4j.jsonrpc-0.12.0.jar;%APP_HOME%\lib\org.eclipse.xtext.xbase-2.26.0.jar;%APP_HOME%\lib\org.eclipse.xtext.common.types-2.26.0.jar;%APP_HOME%\lib\org.eclipse.xtext-2.26.0.jar;%APP_HOME%\lib\org.eclipse.xtext.util-2.26.0.jar;%APP_HOME%\lib\guice-5.0.1.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\org.eclipse.xtend.lib-2.26.0.jar;%APP_HOME%\lib\org.eclipse.xtend.lib.macro-2.26.0.jar;%APP_HOME%\lib\org.eclipse.xtext.xbase.lib-2.26.0.jar;%APP_HOME%\lib\guava-30.1-jre.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\error_prone_annotations-2.3.4.jar;%APP_HOME%\lib\classgraph-4.8.138.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\antlr-runtime-3.2.jar;%APP_HOME%\lib\org.eclipse.emf.ecore.change-2.14.0.jar;%APP_HOME%\lib\org.eclipse.emf.ecore.xmi-2.16.0.jar;%APP_HOME%\lib\org.eclipse.emf.ecore-2.20.0.jar;%APP_HOME%\lib\org.eclipse.emf.common-2.17.0.jar;%APP_HOME%\lib\org.eclipse.equinox.common-3.13.0.jar;%APP_HOME%\lib\org.eclipse.osgi-3.16.0.jar;%APP_HOME%\lib\asm-commons-9.2.jar;%APP_HOME%\lib\asm-analysis-9.2.jar;%APP_HOME%\lib\asm-tree-9.2.jar;%APP_HOME%\lib\asm-9.2.jar;%APP_HOME%\lib\gson-2.8.9.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-qual-3.5.0.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar

@rem Execute acegen-standalone
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %ACEGEN_STANDALONE_OPTS%  -classpath "%CLASSPATH%" org.eclipse.xtext.ide.server.ServerLauncher %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable ACEGEN_STANDALONE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%ACEGEN_STANDALONE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
