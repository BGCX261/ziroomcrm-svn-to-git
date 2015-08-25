package com.ziroom.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import com.common.exception.GeneralException;
import com.common.log.GeneralLog;

/**
 * 
 * @author 孙树林
 */
public class ShellUtils {

	private String execMsg = null;

	/**
	 * 同步主页相关信息
	 * 
	 * @param templatePath
	 * @param picturesPath
	 * @throws GeneralException
	 */
	public void exec(String[] shell) throws GeneralException {
		for (String command : shell) {
			exec(command);
		}
	}
	
	/**
	 * 同步主页相关信息
	 * 
	 * @param templatePath
	 * @param picturesPath
	 * @throws GeneralException
	 */
	public void exec(List<String> shell) throws GeneralException {
		for (String command : shell) {
			exec(command);
		}
	}

	/**
	 * 执行shell脚本命令
	 * 
	 * @param command
	 * @throws GeneralException
	 */
	public void exec(final String command) throws GeneralException {
		Runtime runTime = Runtime.getRuntime();
		try {
			Process process = runTime.exec(command);
			// command标准输出流
			final BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// 错误输出流
			final BufferedReader errordReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			new Thread() {
				// 先处理错误输出流
				public void run() {
					String line = null;
					String error = null;
					try {
						while ((line = errordReader.readLine()) != null) {
							if (line != null) {
								if (error != null) {
									error += line + "\n";
								} else {
									error = line;
								}
							}
						}
						if (error != null) {
							execMsg = "执行外部程序命令\"" + command + "\"失败，请及时处理。否则后果自负。\n" + line;
							GeneralLog.getInstance().info(execMsg);
						}
						// TODO 有问题
						this.interrupt();
					} catch (IOException e) {
						GeneralLog.getInstance().error(e.getMessage());
					}
				}
			}.start();
			new Thread() {
				// 先处理输出流
				public void run() {
					String line = null;
					String msg = null;
					try {
						while ((line = inputReader.readLine()) != null) {
							if (line != null) {
								if (msg != null) {
									msg += line + "\n";
								} else {
									msg = line;
								}
							}
						}
						if (msg != null) {
							GeneralLog.getInstance().info(msg);
							execMsg = "success";
						}
						// TODO 有问题
						this.interrupt();
					} catch (IOException e) {
						GeneralLog.getInstance().error(e.getMessage());
					}
				}
			}.start();
			process.waitFor();
			if(execMsg != "success") {
				// 获得执行后结果
				// throw new GeneralException(execMsg);
			}
		} catch (IOException e) {
			throw new GeneralException(e);
		} catch (InterruptedException e) {
			throw new GeneralException(e);
		}
	}

	/**
	 * 盘符处理，知针对windows操作系统
	 * 
	 * @param path
	 */
	public static String handerDisk(String path) {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");
		if (osName.toUpperCase().indexOf("WINDOWS") != -1) {
			path = "/cygdrive/" + path.substring(0, 1) + path.substring(path.indexOf(":") + 1);
		}
		return path;
	}

	public String getExecMsg() {
		return execMsg;
	}

	/**
	 * @param args
	 * @throws GeneralException
	 */
	public static void main(String[] args) throws GeneralException {
		ShellUtils shellUtils = new ShellUtils();
		String[] commands = { "rsync -av /cygdrive/D/soft/tomcat6/webapps/ziroomcrm/cms/sowing/ 192.168.0.101::test/a" };
		// String commands = "rsync -av
		// /cygdrive/D/soft/tomcat6/webapps/ziroomcrm/cms/sowing/
		// 192.168.0.101::test/a";
		shellUtils.exec(commands);
	}
}
