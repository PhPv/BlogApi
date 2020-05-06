package com.jspring1.demo.controllers.api;


import com.jspring1.demo.model.MusicGroup;
import com.jspring1.demo.model.Post;
import com.jspring1.demo.repo.MusiсGroupRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

// рест контроллер - далее реализуются клиент запросы
@RestController
public class MusicGroupApiController {


    @Autowired
    private MusiсGroupRepository repository;

    @GetMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MusicGroup> groupGet(@RequestParam(value="id", defaultValue = "") String id) {
        return repository.findById(id);
        //200 400 404
    }

    @PostMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicGroup groupAdd(@RequestBody JSONObject body) {
        MusicGroup result = new MusicGroup();
        result.setName(body.get("name").toString());
        result.setStyle(body.get("style").toString());
        result.setCountry(body. get("country").toString());
        repository.save(result);
        return result;
    }


    @DeleteMapping("api/group")
    public String groupDelete(@RequestParam(value="id", defaultValue = "", required = true) String id) {
        MusicGroup MusicGroup = repository.findById(id).orElseThrow();
        repository.delete(MusicGroup);
        return "MusicGroup was deleted";
        //200
        //400 Invalid ID supplied
        //405 Post not found
    }

    @PatchMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicGroup groupPatch(@RequestBody JSONObject body, @RequestParam(value="id", defaultValue = "") String id) {
        MusicGroup result = new MusicGroup();
        result.setId(id);
        result.setName(body.get("name").toString());
        result.setStyle(body.get("style").toString());
        result.setCountry(body.get("country").toString());
        repository.save(result);
        return result;
        // 200
        // 400 Invalid ID supplied
        // 404 Post not found
        // 405 Validation exception
    }

    @GetMapping(value = "api/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public List groupGetAll() {
        return repository.findAll();
        // 200
        // 404 Posts not found
    }

    @DeleteMapping("api/groups")
    public String groupDeleteAll() {
        repository.deleteAll();
        return "All MusicGroup was deleted";
        // 200
        // 404 Posts not found
    }

}
