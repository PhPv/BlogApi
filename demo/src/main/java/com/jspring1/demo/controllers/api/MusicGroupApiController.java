package com.jspring1.demo.controllers.api;

import com.jspring1.demo.exceptions.*;
import com.jspring1.demo.model.MusicGroup;
import com.jspring1.demo.repo.MusicGroupRepository;
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
    private MusicGroupRepository repository;

    @GetMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<MusicGroup> groupGet(@RequestParam(value="id", defaultValue = "") String id) throws Exception400, Exception404{
        if (id.isEmpty()) {
            throw new Exception400();
        }
        if (repository.findById(id).isEmpty()) {
            throw new Exception404();
        }
        return repository.findById(id);
    }

    @PostMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicGroup groupAdd(@RequestBody JSONObject body) throws Exception405 {
        if (
        body.get("name").toString().isEmpty() ||
        body.get("style").toString().isEmpty() ||
        body.get("country").toString().isEmpty())
        {
            throw new Exception405();
        }
        MusicGroup result = new MusicGroup();
        result.setName(body.get("name").toString());
        result.setStyle(body.get("style").toString());
        result.setCountry(body. get("country").toString());
        repository.save(result);
        return result;
        // 401 Unauthorized

    }


    @DeleteMapping("api/group")
    public String groupDelete(@RequestParam(value="id", defaultValue = "", required = true) String id) throws Exception400, Exception404 {
        if (id.isEmpty()) {
            throw new Exception400();
        }
        if (repository.findById(id).isEmpty()) {
            throw new Exception404();
        }
        MusicGroup MusicGroup = repository.findById(id).orElseThrow();
        repository.delete(MusicGroup);
        return "MusicGroup was deleted";
        // 401 Unauthorized
        // 418 Unauthorized admin
    }

    @PutMapping(value = "api/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public MusicGroup groupPatch(@RequestBody JSONObject body, @RequestParam(value="id", defaultValue = "") String id) throws Exception400, Exception404{
        if (id.isEmpty()) {
            throw new Exception400();
        }
        if (repository.findById(id).isEmpty()) {
            throw new Exception404();
        }
        MusicGroup result = new MusicGroup();
        result.setId(id);
        result.setName(body.get("name").toString());
        result.setStyle(body.get("style").toString());
        result.setCountry(body.get("country").toString());
        repository.save(result);
        return result;
        // 401 Unauthorized
    }

    @GetMapping(value = "api/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public List groupGetAll() throws Exception404{
        if (repository.findAll().isEmpty()) {
            throw new Exception404();
        }
        return repository.findAll();
        // 401 Unauthorized

    }

    @DeleteMapping("api/groups")
    public String groupDeleteAll() {
        if (repository.findAll().isEmpty()) {
            throw new Exception404();
        }
        repository.deleteAll();
        return "All MusicGroup was deleted";
        // 401 Unauthorized
        // 418 Unauthorized admin
    }
}
