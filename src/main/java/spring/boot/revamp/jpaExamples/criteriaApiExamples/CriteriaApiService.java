package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaApiService {

    @PersistenceContext
    private final EntityManager entityManager;

    private final UserDetailsCriteriaApiRepository userRepository;


    public CriteriaApiService(EntityManager entityManager,UserDetailsCriteriaApiRepository userRepository){
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }

    public UserDetailsCriteriaApi saveUser(UserDetailsCriteriaApi userDetailsCriteriaApi){
        return this.userRepository.save(userDetailsCriteriaApi);
    }


    public List<UserDetailsCriteriaApi> getUserDetailsByPhoneCriteriaApi(String phone) {
        // 1st Step : Create Criteria Builder object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // 2nd Step : Create criteria query to specify which structure will be our response of
        CriteriaQuery<UserDetailsCriteriaApi> criteriaQuery = criteriaBuilder.createQuery(UserDetailsCriteriaApi.class);

        // 3rd Step : Specify the first(root) table to fetch from
        Root<UserDetailsCriteriaApi> user = criteriaQuery.from(UserDetailsCriteriaApi.class);

        // Step 4: Fetch Join (this triggers a single query with JOIN), works like FETCH JOIN in JPQL queries
        user.fetch("address", JoinType.LEFT); // or INNER

        // 4th Step : write conditions by specifying the Query Result class
        criteriaQuery.select(user);

        //5th Step : Write where conditions and others by predicate,etc
        Specification<UserDetailsCriteriaApi> specification = UserSpecification.equalsPhone(phone);
        Predicate predicate = specification.toPredicate(user,criteriaQuery,criteriaBuilder);
//        Predicate predicate2 = criteriaBuilder.notEqual(user.get("name"),"AA");
//        Predicate finalPredicate = criteriaBuilder.and(predicate2,predicate1);
        criteriaQuery.where(predicate);

        // 6th Step : Create TypedQuery object to execute the query
        TypedQuery<UserDetailsCriteriaApi> query = entityManager.createQuery(criteriaQuery);

        //7th Step : Execute
        return query.getResultList();
    }



    public List<UserDetailsCriteriaApiDTO> getUserDetailsByPhoneCriteriaApiMultiSelect(String phone) {
        // 1st Step : Create Criteria Builder object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // 2nd Step : Create criteria query to specify which structure will be our response of
        CriteriaQuery<UserDetailsCriteriaApiDTO> criteriaQuery = criteriaBuilder.createQuery(UserDetailsCriteriaApiDTO.class);

        // 3rd Step : Specify the first(root) table to fetch from
        Root<UserDetailsCriteriaApi> user = criteriaQuery.from(UserDetailsCriteriaApi.class);

        // 4th Step : write conditions by specifying the Query Result class select multiple fields
        criteriaQuery.multiselect(user.get("name"),user.get("phone"));

        //5th Step : Write where conditions and others by predicate,etc
        Predicate predicate1 = criteriaBuilder.equal(user.get("phone"),phone);
        Predicate predicate2 = criteriaBuilder.notEqual(user.get("name"),"AA");
        Predicate finalPredicate = criteriaBuilder.and(predicate2,predicate1);
        criteriaQuery.where(finalPredicate);

        // 6th Step : Create TypedQuery object to execute the query
        TypedQuery<UserDetailsCriteriaApiDTO> query = entityManager.createQuery(criteriaQuery);

        //7th Step : Execute
        return query.getResultList();
    }


    public List<Object[]> getUserDetailsByPhoneCriteriaApiPaginationAndSorting(String phone) {
        // 1st Step : Create Criteria Builder object
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // 2nd Step : Create criteria query to specify which structure will be our response of
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

        // 3rd Step : Specify the first(root) table to fetch from
        Root<UserDetailsCriteriaApi> user = criteriaQuery.from(UserDetailsCriteriaApi.class);

        Join<UserDetailsCriteriaApi,AddressCriteriaApi> addressCriteriaApiJoin = user.join("address",JoinType.INNER);

        // 4th Step : write conditions by specifying the Query Result class select multiple fields
        criteriaQuery.multiselect(user);

        //5th Step : Write where conditions and others by predicate,etc
        Predicate predicate1 = criteriaBuilder.equal(user.get("phone"),phone);
//        Predicate predicate2 = criteriaBuilder.notEqual(user.get("name"),"AA");
//        Predicate finalPredicate = criteriaBuilder.and(predicate2,predicate1);
        criteriaQuery.where(predicate1);

        // Sorting
        criteriaQuery.orderBy(criteriaBuilder.desc(user.get("name")),criteriaBuilder.asc(addressCriteriaApiJoin.get("city")));

        // 6th Step : Create TypedQuery object to execute the query
        TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);

        // Pagination
        int pageSize = 3;
        int pageNumber = 0;
        query.setFirstResult(pageSize*pageNumber);// Page number or offset
        query.setMaxResults(pageSize); // page size

        //7th Step : Execute
        return query.getResultList();
    }

    // Using Specification API the boilerplate code is gone and we can perform everything very cleanly.
    public List<UserDetailsCriteriaApi> getUserDetailsSpecApi(String phone){
        Specification<UserDetailsCriteriaApi> specification = Specification.allOf(UserSpecification.joinAddress()
                ,UserSpecification.equalsPhone(phone),
                UserSpecification.likeName("Ak"));

        return this.userRepository.findAll(specification);
    }
}
