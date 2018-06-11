package br.com.jwm.lalapizzadelivery.app.core.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

	private static final String CLOUD_NAME = "hl11katfc";
	private static final String API_KEY = "794288352824317";
	private static final String API_SECRET = "I2PAldXPHW6ozdUpHT_Fb14LHiE";

	public Map<String, String> uploadImage(File file) throws IOException {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", CLOUD_NAME,
				"api_key", API_KEY,
				"api_secret", API_SECRET));

		return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}
}
