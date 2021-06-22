package com.david.ServByte.repository;

import com.david.ServByte.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long>{



    Optional<List<ServiceProvider>> findServiceProviderByCity_Name(String parameter);

    @Query(value = "select sp.id, sp.email, sp.Name_of_Restaurant, sp.Phone_number, c.Name, c.short_Name" + " "+
            "from service_provider sp" + " " +
            "inner join city as c on sp.city = c.id" + " "+
            "where c.short_Name like ?1", nativeQuery = true)
    Optional<List<ServiceProvider>> findServiceProviderByCityShortName(String shortName);
}
