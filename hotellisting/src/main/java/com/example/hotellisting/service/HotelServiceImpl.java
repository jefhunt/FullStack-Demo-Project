package com.example.hotellisting.service;

import com.example.hotellisting.codetype.InfoType;
import com.example.hotellisting.codetype.RoomType;
import com.example.hotellisting.model.Hotel;
import com.example.hotellisting.repository.HotelRepository;
import com.example.hotellisting.utils.exception.TransactionInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TransactionInfo transactionInfo;

    @Override
    public Hotel create(String name, String hostName, String neighbourhoodGroup, String neighbourhood, Double latitude, Double longitude, RoomType roomType, Long price) {
        if (null != name) {
            if (null != hostName) {
                if (null != neighbourhoodGroup) {
                    if (null != latitude) {
                        if (null != longitude) {
                            if (null != roomType) {
                                if (null != price) {

                                    Hotel hotel = new Hotel();
                                    hotel.setName(name);
                                    hotel.setHostName(hostName);
                                    hotel.setNeighbourhoodGroup(neighbourhoodGroup);
                                    hotel.setNeighbourhood(neighbourhood);
                                    hotel.setLatitude(latitude);
                                    hotel.setLongitude(longitude);
                                    hotel.setRoomType(roomType);
                                    hotel.setPrice(price);
                                    return save(hotel);

                                } else {
                                    transactionInfo.generateException("invalid.price", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                                    return null;
                                }
                            } else {
                                transactionInfo.generateException("invalid.roomtype", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                                return null;
                            }
                        } else {
                            transactionInfo.generateException("invalid.longitude", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                            return null;
                        }
                    } else {
                        transactionInfo.generateException("invalid.latitude", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                        return null;
                    }
                } else {
                    transactionInfo.generateException("invalid.neighbourhood", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                    return null;
                }
            } else {
                transactionInfo.generateException("invalid.hostname", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                return null;
            }
        } else {
            transactionInfo.generateException("invalid.name", InfoType.ERROR, HttpStatus.BAD_REQUEST);
            return null;
        }

    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void populateDumpData(MultipartFile file) {
        if (null != file) {

            try {
                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                XSSFSheet sheet = workbook.getSheetAt(0);

                int rowNum = 0, colNum = 0, blankCol = 0, blankRow = 0;

                List<Hotel> hotels = new ArrayList<Hotel>();

                // Iterate through each rows one by one
                for (Row row : sheet) {

                    // For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Hotel hotel = new Hotel();

                    while (cellIterator.hasNext() && row.getRowNum() > 0) {


                        Cell cell = cellIterator.next();

                        String textValue=null;
                        double dVal = 0;

                        try {
                            textValue = cell.getStringCellValue();
                        } catch (IllegalStateException e) {
                            try {
                                dVal = cell.getNumericCellValue();
                            } catch (Exception ex) {
                                continue;
                                //throw new HotelInfoAppException("Value found at column number " + colNum + " is not text.", InfoType.ERROR, HttpStatus.BAD_REQUEST);
                            }

                        }

                        if (textValue != null || dVal !=0) {

                            switch (colNum) {
                                case 0:
                                    hotel.setName(textValue);
                                    break;
                                case 1:
                                    hotel.setHostName(textValue);
                                    break;
                                case 2:
                                    hotel.setNeighbourhoodGroup(textValue);
                                    break;
                                case 3:
                                    hotel.setNeighbourhood(textValue);
                                    break;
                                case 4:
                                    hotel.setLatitude(dVal);
                                    break;
                                case 5:
                                    hotel.setLongitude(dVal);
                                    break;
                                case 6:
                                    if (textValue.equalsIgnoreCase("Private room")){
                                        hotel.setRoomType(RoomType.PRIVATE);
                                    }else  if(textValue.equalsIgnoreCase("Entire home/apt")){
                                        hotel.setRoomType(RoomType.HOME_APARTMENT);
                                    }else{
                                        hotel.setRoomType(RoomType.SHARED);
                                    }
//                                    hotel.setRoomType(textValue.equalsIgnoreCase("Private room") ? RoomType.PRIVATE : RoomType.SHARED);
                                    break;
                                case 7:
                                    hotel.setPrice((long) dVal);
                                    break;

                            }
                        }
                        colNum++;
                    }
                    try {
                        save(hotel);
                    } catch (Exception e) {
                    }
                    colNum = 0;

                }

                } catch(IOException e){
                    e.printStackTrace();
                    logger.error("Error while populate dump data");

                }

            }
        }

    public void write(MultipartFile file) { // this can be automate for not exist directory
        Path filepath = Paths.get("raw/", file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        }catch (Exception r){
            logger.error("Internal Error");
        }
    }

       public void populateDataWithCSVFile(MultipartFile file){
        //copy to server
           write(file);

           BufferedReader br = null;
           String line = "";
           String cvsSplitBy = ",";

           try {

               br = new BufferedReader(new FileReader("raw/Singapore_Listings3026f58.csv"));
               while ((line = br.readLine()) != null) {

                   // use comma as separator
                   String[] hotelData = line.split(cvsSplitBy);
                   if (hotelData[4].contains("latitude")){
                       continue;
                   }

//                   System.out.println("Country [code= " + hotelData[4] + " , name=" + hotelData[5] + "]");

                   RoomType roomType;
                   if (hotelData[6].equalsIgnoreCase("Private room")){
                       roomType =RoomType.PRIVATE;
                   }else  if(hotelData[6].equalsIgnoreCase("Entire home/apt")){
                       roomType =RoomType.HOME_APARTMENT;
                   }else{
                       roomType =RoomType.SHARED;
                   }
                   create(hotelData[0],hotelData[1],hotelData[2],hotelData[3],Double.valueOf(hotelData[4]),Double.valueOf(hotelData[5]),roomType,Long.valueOf(hotelData[7]));

               }



           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               if (br != null) {
                   try {
                       br.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
        }

    @Override
    public List<Hotel> getByName(String name) {
        return hotelRepository.findByNameContaining(name);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
