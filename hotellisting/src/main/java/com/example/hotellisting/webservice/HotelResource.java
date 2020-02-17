package com.example.hotellisting.webservice;

import com.example.hotellisting.service.HotelService;
import com.example.hotellisting.utils.ResponseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("hotels")
public class HotelResource {

    @Autowired
    private ResponseMessageService responseMessageService;

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity getData(@RequestParam("name")String name) {

        if (name != null){
            return ResponseEntity
                    .ok(responseMessageService
                            .generateResponseMessage(hotelService.getByName(name), "", HttpStatus.OK));

        }else{
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(responseMessageService
                    .generateErrorMessage("","invalid",HttpStatus.FORBIDDEN));
        }


    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
            return ResponseEntity
                    .ok(responseMessageService
                            .generateResponseMessage(hotelService.getAll(), "", HttpStatus.OK));


    }
    //Populate dump data in db

    @RequestMapping(value = "/csv-file",method = RequestMethod.POST)
    public ResponseEntity populateData(@RequestParam("file") MultipartFile file) {

        if (null != file){
            //hotelService.populateDumpData(file);
            hotelService.populateDataWithCSVFile(file);

            return ResponseEntity
                    .ok(responseMessageService
                            .generateResponseMessage("", "csv.data", HttpStatus.OK));

        }else{
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(responseMessageService
                            .generateErrorMessage("","invalid.csv",HttpStatus.FORBIDDEN));
        }


    }

}
