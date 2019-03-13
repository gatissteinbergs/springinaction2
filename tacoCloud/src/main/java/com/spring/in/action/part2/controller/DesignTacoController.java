package com.spring.in.action.part2.controller;

import com.spring.in.action.part2.model.Taco;
import com.spring.in.action.part2.repository.TacoRepository;
import com.spring.in.action.part2.resource.TacoResource;
import com.spring.in.action.part2.resource.TacoResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//Not in the spring data rest base path

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    private TacoRepository tacoRepository;

    @Autowired
    EntityLinks entityLinks;

    public DesignTacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

//    @GetMapping("/recent")
//    public Iterable<Taco> recentTacos() {
//        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//        return tacoRepository.findAll(page).getContent();
//    }

//    @GetMapping("/recent")
//    public Resources<TacoResource> recentTacos() {
//        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//        List<Taco> tacos = tacoRepository.findAll(page).getContent();
//
//        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
//        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
//        recentResources.add(linkTo(methodOn(DesignTacoController.class)
//                .recentTacos())
//                .withRel("recents"));
//        return recentResources;
//    }

//    @GetMapping("/{id}")
//    public Taco tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optTaco = tacoRepository.findById(id);
//        return optTaco.orElse(null);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepository.findById(id);
        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }
}
