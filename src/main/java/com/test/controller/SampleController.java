package com.test.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.Sample;
import com.test.repository.SampleRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/api/sample")
public class SampleController extends RepositoryBasedRestController<Sample, String, SampleRepository> {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Inject
    @Named("sampleRepository")
    @Override
    public void setRepository(SampleRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/custom",method = RequestMethod.GET)
    @ResponseBody
    public List<Sample> getAll(){
        logger.info(" --# custom method executed -- ");
        return this.repository.findAll();
    }

    @Override
    public Sample create(@RequestBody Sample sample){
        logger.info("--## saving new record-- ");
        return this.repository.save(sample);
    }


}
