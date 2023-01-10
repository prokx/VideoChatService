package com.hwan.firstweek.room.controller;

import com.hwan.firstweek.room.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@Api
public class RoomController {

    private final RoomService roomService;

    @ApiOperation(value="post")
    @PostMapping("")
    public void insertRoom(){

    }

    @ApiOperation(value="get Room1")
    @GetMapping("/{id}")
    public void searchRoom(){

    }

    @ApiOperation(value = "search Room")
    @GetMapping("")
    public void searchRoomList(){

    }

    @ApiOperation(value = "update Room")
    @PutMapping("/{id}")
    public void updateRoom(){

    }


    @DeleteMapping("/{id}")
    public void deleteRoom(){

    }

}
