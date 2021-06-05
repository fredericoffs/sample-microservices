package com.fredericoffs.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fredericoffs.hrworker.entities.Worker;
import com.fredericoffs.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);

	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository repository;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("config = " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// imprimir o nro da porta que está rodando
		logger.info("Port = " + env.getProperty("local.server.port"));

		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}
}
