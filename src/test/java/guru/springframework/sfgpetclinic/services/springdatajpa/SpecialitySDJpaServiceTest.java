package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * @author Ronnen Nagal
 * @created 04/11/2020 - 4:34 p.m.
 * @project testing-junit5-mockito
 */
@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    /*
     a brand new mock will be created
     for each of the following methods
     */
    @Test
    void deleteById() {
        /*
         calling 'specialtyRepository' twice
         with 'deleteById'
         */
        service.deleteById(1L);
        service.deleteById(1L);

        /*
         verify that 'specialtyRepository' was called
         twice using 'deleteById' method
         */
        verify(specialtyRepository, times(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtLeast() {
        /*
         calling 'specialtyRepository' twice
         with 'deleteById'
         */
        service.deleteById(1L);
        service.deleteById(1L);

        /*
         verify that 'specialtyRepository' was called
         as least once using 'deleteById' method
         */
        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
    }

    @Test
    void deleteByIdAtMost() {
        /*
         calling 'specialtyRepository' twice
         with 'deleteById'
         */
        service.deleteById(1L);
        service.deleteById(1L);

        /*
         verify that 'specialtyRepository' was called
         as Most twice using 'deleteById' method
         */
        verify(specialtyRepository, atMost(2)).deleteById(1L);
    }

    @Test
    void deleteByIdAtNever() {
        /*
         calling 'specialtyRepository' twice
         with 'deleteById'
         */
        service.deleteById(1L);
        service.deleteById(1L);

        /*
         verify that 'specialtyRepository' was never called
         with a '2L' long-value using 'deleteById' method
         */
        verify(specialtyRepository, atLeastOnce()).deleteById(1L);
        verify(specialtyRepository, never()).deleteById(2L);
    }

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }
}

