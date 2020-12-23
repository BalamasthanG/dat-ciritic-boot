/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dat_ciritic_server_spring_boot.dat_ciritic_boot;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatCriticController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/test")
	public String welcome(Map<String, Object> model) {
//		model.put("time", new Date());
//		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/DatCritic/build")
	public void buildInfo(HttpServletRequest request,HttpServletResponse response) {
		Path file = Paths.get("D:\\tool\\Dat-critic-build-info\\build-info.txt");
		System.out.println(request.getRemoteHost());
		if (!Files.exists(file)) {
			System.out.println("Not exist "+file);
		}else{
			response.setContentType("text/plain");
			response.setHeader("Content-Disposition", "attachment; "+
					"filename=build-info.txt");
			OutputStream os;
			try {
				os = response.getOutputStream();
				Files.copy(file, response.getOutputStream());
				os.close();
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Download");
		}
	}

	@RequestMapping("/DatCritic/auto")
	public void autoUpdate(HttpServletRequest request,HttpServletResponse response) {
		Path file = Paths.get("D:\\tool\\Dat-critic-auto-update-server\\2\\Dat-Critic.zip");
		System.out.println(request.getRemoteHost());
		if (!Files.exists(file)) {
			System.out.println("Not exist "+file);
		}else{
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition", "attachment; "+
					"filename=Dat-Critic.zip");
			OutputStream os;
			try {
				os = response.getOutputStream();
				Files.copy(file, response.getOutputStream());
				os.close();
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Download");
		}
	}

	@RequestMapping("/DatCritic/update")
	public void updateInfo(HttpServletRequest request,HttpServletResponse response) {
		Path file = Paths.get("D:\\tool\\Dat-Critic-update-info\\update_info.txt");
		System.out.println(request.getRemoteHost());
		if (!Files.exists(file)) {
			System.out.println("Not exist "+file);
		}else{
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition", "attachment; "+
					"filename=download-info.txt");
			OutputStream os;
			try {
				os = response.getOutputStream();
				Files.copy(file, response.getOutputStream());
				os.close();
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Download");
		}
	}

	@RequestMapping("/DatCritic/latest")
	public void latest(HttpServletRequest request,HttpServletResponse response) {
		Path file = Paths.get("D:\\tool\\Dat-critic-auto-update-server\\2_download\\Dat-Critic.zip");
		System.out.println(request.getRemoteHost());
		if (!Files.exists(file)) {
			System.out.println("Not exist "+file);
		}else{
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition", "attachment; "+
					"filename=Dat-Critic.zip");
			OutputStream os;
			try {
				os = response.getOutputStream();
				Files.copy(file, response.getOutputStream());
				os.close();
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Download");
		}
	}

}
