package com.ctb.tex2gif;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

@Path("/generate")
public class GeneratePic {

	public static Logger log = Logger.getLogger(GeneratePic.class);

	@GET
	@Path("/gif")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String toGIF(@QueryParam("latex") String latex) {

		log.info("latex:" + latex);

		// 随机生成名字,生成latex文件
		String filename = StringUtil.getRandomChar();
		File file = new File(ConfigUtil.readValue("textogif_dir") + filename);
		try {
			FileUtils.writeStringToFile(file, TexModel.getLaTex(latex, 0));
		} catch (IOException e) {
			log.error("latex file create failure!");
			e.printStackTrace();
		}
		// 执行textogif命令 参数latex文件
		String cmd = ConfigUtil.readValue("textogif_dir") + "generate.sh "
				+ filename;
		log.info("exec:" + cmd);

		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmd);
			// int exitVal = proc.exitValue();
			int exitVal = proc.waitFor();
			log.info("Process exitValue: " + exitVal);

		} catch (IOException e) {
			log.error("execuate textogif command  IOException failure!");
			e.printStackTrace();
		} catch (InterruptedException e) {
			log.error("execuate textogif command InterruptedException failure!");
			e.printStackTrace();
		}

		// 返回url

		return ConfigUtil.readValue("nginx_url") + filename + ".gif";
	}
}
