package com.octo.EventSourceExample.query;

import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<RequestQueryEntity, String> {

}
