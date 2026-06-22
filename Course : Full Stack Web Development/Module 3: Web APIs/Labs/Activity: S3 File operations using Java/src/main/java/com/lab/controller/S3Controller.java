package com.lab.controller;

import com.lab.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    /* TODO 1: define a POST HTTP endpoint for uploading files,
     *  set the endpoint URL to "/upload" so that this function is triggered when a POST request is made to /upload
    */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("bucketName") String bucketName) {
        try {
            // create a temporary file path in the system's temp directory to hold the uploaded file temporarily
            Path tempFile = Files.createTempFile(Paths.get(System.getProperty("java.io.tmpdir")), file.getOriginalFilename(), null);
            // transfer the uploaded file's content to the temporary file created above
            file.transferTo(tempFile.toFile());
            /* TODO 2: use the s3Service to upload the file to the specified S3 bucket
               * call the uploadFile method on the s3Service object to handle the file upload to S3.
                *  pass three arguments:
                *   the name of the bucket where we want to store the file (bucketName)
                *   the file name to save it as in the S3 bucket (file.getOriginalFilename())
                *   the temporary file path we created earlier (tempFile) to access the file’s content for upload.
                *   this method will return a result string, often containing a URL or confirmation message from S3 if the upload is successful.
            * TODO 3:store this response in a variable called 'result' so it can be passed in the response, send back to the client.
            */
            String result = s3Service.uploadFile(bucketName, file.getOriginalFilename(), tempFile);
            // Return a success response with the result of the upload
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File upload failed: " + e.getMessage());
        }
    }
    /* TODO 4: set up a GET endpoint for file downloads
     *   use @GetMapping to create an endpoint that listens for GET requests.
     *   the URL pattern "/download/{bucketName}/{fileName}" captures the bucket name and
     *    file name from the URL path to locate the file.
    */
    @GetMapping("/download/{bucketName}/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String bucketName, @PathVariable String fileName) {
        try {
            /* TODO 5:use the s3Service to download the file from the specified S3 bucket
             *   all the downloadFile method on s3Service to fetch the file from the
             *   given S3 bucket (bucketName) with the specified file name (fileName).
             *   this method returns the file as a stream (ResponseInputStream) that you can read
             */
            /* TODO 6: store the stream in a variable called s3Object
              *  so you can easily access and work with the file data
            * */
            ResponseInputStream<GetObjectResponse> s3Object = s3Service.downloadFile(bucketName, fileName);
            /* read the contents of the file from the InputStream into a byte array
             *   use the readAllBytes() method to read the entire content of the file into a byte array (fileBytes)
             *    this byte array will represent the file data, which can be returned as part of the HTTP response
             */
            byte[] fileBytes = s3Object.readAllBytes(); // Read the file into bytes
            // close the stream to release any resources used by the InputStream
            s3Object.close();

            /* set HTTP headers to tell the browser that this response should be downloaded as a file.
             *   create an HttpHeaders object to set necessary headers for the download response.
             *   set the content-disposition header to "attachment" with the original file name, prompting the browser to download it.
             *   set the Content-Type header to "application/octet-stream" to indicate this is a binary file
             */
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // Return the ResponseEntity with the file bytes and headers
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileBytes);
        } catch (IOException e) {
            // Handle errors by returning a 500 error response with a message
            e.printStackTrace();
            return ResponseEntity.status(500).body(("Failed to retrieve file: " + e.getMessage().getBytes()).getBytes());
        }
    }

    /* TODO 7: set up a DELETE endpoint to remove a file
     *  for DELETE requests at "/delete/{bucketName}/{fileName}" and
     *  uses {bucketName} and {fileName} from the URL
    * */
    @DeleteMapping("/delete/{bucketName}/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String bucketName, @PathVariable String fileName) {
        try {
            /* TODO 8: call s3Service to delete the file from the specified S3 bucket
            *   pass in the bucket name and file name so that s3Service can locate and delete the file
            * */
            String result = s3Service.deleteFile(bucketName, fileName);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // handle errors by returning a 500 response with a failure message
            e.printStackTrace();
            //  if there’s an error during deletion, we catch the exception and send a 500 error response with the error message.
            return ResponseEntity.status(500).body("File deletion failed: " + e.getMessage());
        }
    }

    /* set up a POST endpoint to create a new bucket
    *   this endpoint for POST requests at "/create-bucket/{bucketName}"
    *   the {bucketName} placeholder allows to capture the name of the bucket from the URL.
     */
    @PostMapping("/create-bucket/{bucketName}")
    public ResponseEntity<String> createBucket(@PathVariable String bucketName) {
        try {
            /* call s3Service to create a new bucket with the specified name,
            * pass the bucket name to s3Service, which handles the creation in S3
            * createBucket method will return a confirmation message as a String
            * this message will confirm if the bucket was created successfully
            * */
            String result = s3Service.createBucket(bucketName);
            // Return a success response with the result message
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // handle any errors by returning a 500 response with a failure message
            e.printStackTrace();
            return ResponseEntity.status(500).body("Bucket creation failed: " + e.getMessage());
        }
    }
}
