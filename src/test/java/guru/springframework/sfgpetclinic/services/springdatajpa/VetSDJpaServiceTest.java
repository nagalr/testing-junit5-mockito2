package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Ronnen Nagal
 * @created 04/11/2020 - 5:42 p.m.
 * @project testing-junit5-mockito
 */
@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    /*
     the type 'specialtyRepository' doing all of the work
     (CRUD work) hence, we Mock it.
     It's in the specialitySDJpaService class, and that
     class-reference receives 'InjectMocks' annotation,
     meaning, the created Mock will inject here.
     (injected into the class-constructor)
     In the method 'deleteById' we verify the Mock
     was called (after executing 'deleteById') once.
     */
    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    void deleteById() {
        specialitySDJpaService.deleteById(1L);
        verify(specialtyRepository, times(1)).deleteById(1L);
    }
}


