package com.hwan.firstweek.room.repository;

import com.hwan.firstweek.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

}
