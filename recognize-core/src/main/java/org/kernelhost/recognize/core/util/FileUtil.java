package org.kernelhost.recognize.core.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class FileUtil {

	private FileUtil() { }
	
	public static Metadata getMetaData(byte[] content) {
		ContentHandler contenthandler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		ParseContext context = new ParseContext();
		Parser parser = new AutoDetectParser();
		
		try {
			parser.parse(new ByteArrayInputStream(content), contenthandler, metadata, context);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (TikaException e) {
			throw new RuntimeException(e);
		}
		
		return metadata;
	}
	
	public static String getContentType(byte[] content) {
		return getMetaData(content).get(Metadata.CONTENT_TYPE);
	}
	
	public static String getChecksum(byte[] content) {
		return DigestUtils.md5Hex(content);
	}
	
}
