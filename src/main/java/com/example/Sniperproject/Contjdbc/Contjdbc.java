package com.example.Sniperproject.Contjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sniperproject.Pojojdbc.Pojojdbc;
import com.example.Sniperproject.Servicejdbc.Servicejdbc;

import jakarta.websocket.server.PathParam;

@RestController
public class Contjdbc {
	@Autowired
Servicejdbc sc;

@PostMapping("/insert")
public int insert(@RequestBody Pojojdbc e) {
	int i=sc.insert(e);
	if(i>0) {
		return 1;
	}
	else {
		return 0;
	}
}

//putmapping
@PutMapping("/update")
public int updateval(@RequestParam int id) {
int i=sc.updateval(id);
if(i>0) {
	return 1;
}
else {
	return 0;
}
}

//deletemapping
@DeleteMapping("/delete/{id}")
public int deleteval(@PathVariable int id) {
int i=sc.deleteval(id);
if(i>0) {
	return 1;
}
else {
	return 0;
}
}

//getmapping

@GetMapping("/select")
public List<Object> getmap(@RequestParam String name) {
	return sc.getmap(name);
}
}

