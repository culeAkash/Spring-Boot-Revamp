package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NativeDynamicQueryService {

    @PersistenceContext
    private final EntityManager entityManager;

    public NativeDynamicQueryService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void getUserDetailsByNameNativeDynamicQuery(String userName){
        // Create the native query
        StringBuilder queryBuilder = new StringBuilder("SELECT ud.user_name AS user_name, ud.phone AS phone,ua.city as city ");
        queryBuilder.append("FROM user_details_native_query ud ");
        queryBuilder.append("JOIN user_address ua ON ud.user_address_id = ua.address_id ");
        queryBuilder.append("WHERE 1=1 ");

        // create the params list
        List<Object> parameters = new ArrayList<>();

        //Dynamically add conditions
        if(userName!=null && !userName.isEmpty()){
            queryBuilder.append("AND ud.user_name = ?");
            parameters.add(userName);
        }

        // Create the native query
        Query nativeQuery = entityManager.createNativeQuery(queryBuilder.toString());

        // Set the params to the query
        for(int index = 0;index < parameters.size();index++){
            nativeQuery.setParameter(index+1,parameters.get(index));
        }

        // Execute and get results
        List<Object[]> result = nativeQuery.getResultList();



        // Map the result to USER DTO
        for(Object[] res : result){
            System.out.println(res[0] + " " + res[1] + " " + res[2]);
        }
    }


}
