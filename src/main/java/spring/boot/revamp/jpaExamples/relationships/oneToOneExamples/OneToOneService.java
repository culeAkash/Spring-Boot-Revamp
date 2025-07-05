package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;

import org.springframework.stereotype.Service;

@Service
public class OneToOneService {

    private final OneToOneUserRepository userRepository;
    private final OneToOneAddressRepository addressRepository;

    public OneToOneService(OneToOneUserRepository userRepository,OneToOneAddressRepository addressRepository){
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public UserDetailsInOneToOneUni saveUser(SaveUserDetailsDTO userDetailsInOneToOneUni){
        UserDetailsInOneToOneUni userDetailsInOneToOneUniToSave = UserDetailsInOneToOneUni.builder()
                .phone(userDetailsInOneToOneUni.getPhone())
                .name(userDetailsInOneToOneUni.getName())
                .userAddress(
                        UserAddressOneToOneUni.builder()
                                .state(userDetailsInOneToOneUni.getAddressDTO().getState())
                                .street(userDetailsInOneToOneUni.getAddressDTO().getStreet())
                                .id(
                                        UserAddressOneToOneCK.builder()
                                                .city(userDetailsInOneToOneUni.getAddressDTO().getCity())
                                                .pinCode(userDetailsInOneToOneUni.getAddressDTO().getPinCode())
                                                .build()
                                )
                                .build()
                )
                .build();
        return this.userRepository.save(userDetailsInOneToOneUniToSave);
    }

    public SaveUserDetailsDTO findById(Long primaryKey){
        UserDetailsInOneToOneUni  userDetailsInOneToOneUni = this.userRepository.findById(primaryKey).orElse(null);

        // when using LAZy loading, fetching data forcefully
        System.out.println("when using LAZy loading, fetching data forcefully");
        UserAddressOneToOneUni userAddressOneToOneUni = userDetailsInOneToOneUni.getUserAddress();

        return SaveUserDetailsDTO.builder()
                .name(userDetailsInOneToOneUni.getName())
                .phone(userDetailsInOneToOneUni.getPhone())
                .id(userDetailsInOneToOneUni.getId())
                .addressDTO(
                        SaveAddressDTO.builder()
                                .city(userAddressOneToOneUni.getId().getCity())
                                .pinCode(userAddressOneToOneUni.getId().getPinCode())
                                .state(userAddressOneToOneUni.getState())
                                .street(userAddressOneToOneUni.getStreet())
                                .build()
                )
                .build();
    }
}
