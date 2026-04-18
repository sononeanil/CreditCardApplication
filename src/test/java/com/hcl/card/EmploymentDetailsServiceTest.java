package com.hcl.card;

import com.hcl.card.controller.EmploymentDetailsController;

@ExtendWith(MockitoExtension.class)
class EmploymentDetailsServiceTest {

    @Mock
    private EmploymentDetailsRepository repository;

    @Mock
    private EmploymentDetailsMapper mapper;

    @InjectMocks
    private EmploymentDetailsService service;

    private EmploymentDetails entity;
    private EmploymentDetailsRequestDTO requestDTO;
    private EmploymentDetailsResponseDTO responseDTO;

    @BeforeEach
    void setup() {
        entity = new EmploymentDetails();
        entity.setEmploymentId(1L);
        entity.setEmployerName("Google");
        entity.setJobTitle("Software Engineer");

        requestDTO = new EmploymentDetailsRequestDTO();
        requestDTO.setEmployerName("Google");
        requestDTO.setJobTitle("Software Engineer");

        responseDTO = new EmploymentDetailsResponseDTO();
        responseDTO.setEmploymentId(1L);
        responseDTO.setEmployerName("Google");
        responseDTO.setJobTitle("Software Engineer");
    }
    
    @Test
    void shouldCreateEmployment() {
        when(mapper.toEntity(requestDTO)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDTO(entity)).thenReturn(responseDTO);

        EmploymentDetailsResponseDTO result = service.create(requestDTO);

        assertNotNull(result);
        assertEquals("Google", result.getEmployerName());

        verify(repository, times(1)).save(entity);
    }
    
    
    @Test
    void shouldReturnEmploymentListByUserId() {
        when(repository.findByUserId(10L)).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(responseDTO);

        List<EmploymentDetailsResponseDTO> result = service.getByUserId(10L);

        assertEquals(1, result.size());
        verify(repository).findByUserId(10L);
    }
    
    @Test
    void shouldUpdateEmployment() {
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        doNothing().when(mapper).updateEntity(entity, requestDTO);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDTO(entity)).thenReturn(responseDTO);

        EmploymentDetailsResponseDTO result = service.update(1L, requestDTO);

        assertNotNull(result);
        verify(mapper).updateEntity(entity, requestDTO);
        verify(repository).save(entity);
    }
}