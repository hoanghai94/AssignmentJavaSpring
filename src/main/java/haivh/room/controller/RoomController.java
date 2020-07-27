package haivh.room.controller;

import haivh.room.entity.Room;
import haivh.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Room> allRoom = roomService.findByStatusNot(Room.statusEnum.Delete.value);
        model.addAttribute("allRoom", allRoom);
        return "index";
    }
}
