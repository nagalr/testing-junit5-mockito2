package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Test
    void testDeleteByObject() {
        Speciality speciality = new Speciality();

        // Mocking the delete operation
        service.delete(speciality);

        /*
         Verify the deletion was executed by the Mock - 'specialtyRepository'
         as expected, and it was called ones, the default behaviour
        */
        verify(specialtyRepository).delete(any(Speciality.class));
    }

    @Test
    void findByIdTest() {

        Speciality speciality = new Speciality();

        /*
         Checking findById method and it's 'Speciality' return type
         Use the Mock 'specialtyRepository' to findById
         then Return an Optional of 'speciality' (accepts Optional)
        */
        when(specialtyRepository.findById(1L))
                .thenReturn(Optional.of(speciality));

        // Creating the call that we defined it's outcome above
        Speciality foundSpeciality = service.findById(1L);

        // Checks that 'foundSpeciality' is not null
        assertNotNull(foundSpeciality);

        /*
         Verify the Mock implementation - 'specialtyRepository'
         was called ones
        */
        verify(specialtyRepository, times(1))
                .findById(1L);
    }

    /*
     a brand new mock will be created
     for each of the following methods
     */
    @Test
    void deleteById() {
        /*
         calling 'specialtyRepository' Mock twice
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

