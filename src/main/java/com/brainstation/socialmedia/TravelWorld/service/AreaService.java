package com.brainstation.socialmedia.TravelWorld.service;

import com.brainstation.socialmedia.TravelWorld.model.Area;
import com.brainstation.socialmedia.TravelWorld.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaRepository areaRepository;

    public List<Area> getAllArea() {
        List<Area> areas = areaRepository.findAll();
        return areas;
    }
}