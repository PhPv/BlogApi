package com.jspring1.demo.controllers.api;


import com.jspring1.demo.model.MusicGroup;
import com.jspring1.demo.repo.MusiсGroupRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class MusicGroupApiController {

    @Autowired
    private MusiсGroupRepository repository;

    @GetMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MusicGroup> groupGet(@RequestParam(value="id", defaultValue = "") String id) {
        return repository.findById(id);
        //200 400 404
    }

    @RequestMapping(value = "api/group", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicGroup groupAdd(@RequestBody JSONObject body) {
        MusicGroup result = new MusicGroup();
        result.setName(body.get("name").toString());
        result.setStyle(body.get("style").toString());
        result.setCountry(body. get("country").toString());
        repository.save(result);
        return result;
    }

}
