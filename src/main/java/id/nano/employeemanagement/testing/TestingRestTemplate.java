package id.nano.employeemanagement.testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.nano.employeemanagement.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingRestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;
    /*
    jika test api nya dari local : API Harus RUNNING
     */

    @Test
    public void listSukses() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9091/api/v1/rekening/list?size=10&page=0", HttpMethod.GET, null, String.class);
        System.out.println("response  =" + exchange.getBody()); //JACKSON Parsing
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
    }
//
//    @Test
//    public void getIdSukses() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        Integer id = 20;
//        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9091/api/v1/employee/"+id, HttpMethod.GET, null, String.class);
//        System.out.println("response  =" + exchange.getBody());
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//    }
//
//    @Test
//    public void  saveSukses() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        String bodyTesting = "{\n" +
//                "    \"nama\": \"Riki Aldi Pari\",\n" +
//                "    \"jenis\": \"BCA\",\n" +
//                "    \"rekening\": \"12345678\", \n" +
//                "    \"employee\": {\n" +
//                "        \"id\": 29\n" +
//                "    }\n" +
//                "}";
//
//        /*
//        cara : Map
//         */
//        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
//        System.out.println("bodyTesting  =" + bodyTesting);
//        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9091/api/v1/rekening/save", HttpMethod.POST, entity, String.class);
//        System.out.println("response  =" + exchange.getBody());
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//
//    }
//
//    @Test
//    public void  updateSukses() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        String bodyTesting = "{\n" +
//                "    \"id\":\"8\",\n" +
//                "    \"nama\":\"pulpen update\",\n" +
//                "    \"stok\":\"1\",\n" +
//                "    \"satuan\":\"pcs\",\n" +
//                "    \"harga\":\"123\"\n" +
//                "}";
//        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);
//
//        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9091/api/v1/sp/barang/update", HttpMethod.PUT, entity, String.class);
//
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//        System.out.println("response  =" + exchange.getBody());
//    }
//
//
//    public void saveSuccessAgain() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "*/*");
//        headers.set("Content-Type", "application/json");
//        String bodyTesting = "{\n" +
//                "    \"name\":\"Yolanda\",\n" +
//                "    \"address\":\"jakarta\",\n" +
//                "    \"dob\":\"2023-01-01\",\n" +
//                "    \"status\":\"active\",\n" +
//                "    \"detailKaryawan\":{\n" +
//                "        \"nik\":\"123124\",\n" +
//                "        \"npwp\":\"120394\"\n" +
//                "    }\n" +
//                "}";
//
//        HttpEntity<String> entity = new HttpEntity<>(bodyTesting, headers);
//        System.out.println("bodyTesting = " + bodyTesting);
//        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:9091/api/v1/employee/save", HttpMethod.POST, entity, String.class);
//        System.out.println("response = " + exchange.getBody());
//        assertEquals(HttpStatus.OK, exchange.getStatusCode());
//
//        Employee test = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            JsonNode root = mapper.readTree(exchange.getBody());
//            test = mapper.treeToValue(root.path("data"), Employee.class);
//            System.out.println(String.valueOf(test));
//        } catch (Exception e) {
//            System.out.println("error = " + e.getMessage());
//        }
//
//        assertNotNull("Response body is null", test);
//        assertEquals("Name does not match", "Yolanda", test.getName());
//    }
}
