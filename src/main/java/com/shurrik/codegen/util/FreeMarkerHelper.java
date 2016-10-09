package com.shurrik.codegen.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.util.StringUtils;

/**
 * @author lip 创建于	2012-4-13	上午10:00:33 
 */
public class FreeMarkerHelper {

	/**	渲染
	 * @param model
	 * @param templatePath
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public String render(Map<String, Object> model,String templatePath) throws IOException, TemplateException
	{
		Configuration configuration = new Configuration();
		TemplateLoader templateLoader=null;

		//使用FileTemplateLoader
		URL url = this.getClass().getClassLoader().getResource("template");
		String path = url.getPath();
//		String path = "d://codegen//codegen//target//codegen-jar-with-dependencies.jar!//template";
//		templateLoader=new FileTemplateLoader(new File(templatePath));
//		templateLoader=new FileTemplateLoader(new File("d://template"));

//		path="/WEB-INF/classes/com/xxx/tag/templates/page/xxx.ftl";

//		configuration.setTemplateLoader(templateLoader);
//		FileTemplateLoader fileTemplateLoader = new FileTemplateLoader();
//		fileTemplateLoader.findTemplateSource(templatePath);

		Template tpl = configuration.getTemplate(templatePath,"utf-8");
//		Template tpl = configuration.getTemplate(templatePath);
		return FreeMarkerTemplateUtils.processTemplateIntoString(tpl,
				model);
	}
}
