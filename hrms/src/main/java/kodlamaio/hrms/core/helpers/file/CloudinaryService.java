package kodlamaio.hrms.core.helpers.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sun.jdi.Field;

@Service
public class CloudinaryService {

	Cloudinary cloudinary;

	private Map<String, String> valuesMap = new HashMap();

	public CloudinaryService() {
		valuesMap.put("cloud_name", "barisaslan");
		valuesMap.put("api_key", "897628864136712");
		valuesMap.put("api_secret", "IJE9teL5-OzMNWeHs1MhOuIZrXQ");
		cloudinary = new Cloudinary(valuesMap);
	}

	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}

	public Map delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}

	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		return file;
	}

}
