package pl.papug.papug.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @GetMapping("/images/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Resource resource = new ClassPathResource("static/images/" + imageName);

        if (resource.exists()) {
            MediaType mediaType;
            if (imageName.endsWith(".svg")) {
                mediaType = MediaType.parseMediaType("image/svg+xml");
            } else {
                mediaType = MediaType.IMAGE_JPEG;
            }
            byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
            return ResponseEntity.ok().contentType(mediaType).body(imageBytes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
