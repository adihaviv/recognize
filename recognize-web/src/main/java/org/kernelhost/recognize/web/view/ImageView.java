package org.kernelhost.recognize.web.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kernelhost.recognize.core.util.FileUtil;
import org.springframework.web.servlet.View;

public class ImageView implements View {

	private String name;
	private byte[] bytes;
	private int contentLength;
	private String contentType;

	public ImageView(String name, byte[] bytes) {
		this.name = name;
		this.bytes = bytes;
		this.contentLength = bytes.length;
		this.contentType = FileUtil.getContentType(bytes);
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType(contentType);
		response.setContentLength(contentLength);
		response.setHeader("Content-Disposition", "inline; filename=\"" + name + "\"");
		
		InputStream in = new ByteArrayInputStream(bytes);
		OutputStream out = response.getOutputStream();
		int length = 0;
		byte[] buffer = new byte[1024];
		while ((length = in.read(buffer)) >= 0) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}

	public String getName() {
		return name;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public int getContentLength() {
		return contentLength;
	}

	@Override
	public String getContentType() {
		return contentType;
	}

}
