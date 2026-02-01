package ru.perm.v.family.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonEntityTest {

    @Test
    void setName() {
        for (int i = 0; i < 100; i++) {
            PersonEntity personEntity = new PersonEntity();
            personEntity.setName("test" + i);
            assertEquals("test" + i, personEntity.getName());
        }
    }

    @Test
    void setId() {
        for (int i = 0; i < 100; i++) {
            PersonEntity personEntity = new PersonEntity();
            personEntity.setId((long) i);
            assertEquals(i, personEntity.getId());
        }
    }

    @Test
    void testEquals() {
        PersonEntity personEntity1 = new PersonEntity(1L, "test1","+79999999999");
        PersonEntity personEntity2 = new PersonEntity(1L, "test1","+79999999999");

        assertEquals(personEntity1, personEntity2);
    }

    @Test
    void testNotEqualsById() {
        PersonEntity personEntity1 = new PersonEntity(1L, "test2","+79999999999");
        PersonEntity personEntity2 = new PersonEntity(2L, "test2","+79999999999");

        assertNotEquals(personEntity1, personEntity2);
    }

    @Test
    void testNotEqualsByName() {
        PersonEntity personEntity1 = new PersonEntity(1L, "test1","+79999999999");
        PersonEntity personEntity2 = new PersonEntity(1L, "test2","+79999999999");

        assertNotEquals(personEntity1, personEntity2);
    }

    @Test
    void testEqualsHashCode() {
        for (int i = 0; i < 100; i++) {
            PersonEntity personEntity1 = new PersonEntity((long) i, "test" + i, "+79999999999");
            PersonEntity personEntity2 = new PersonEntity((long) i, "test" + i, "+79999999999");

            assertEquals(personEntity1.hashCode(), personEntity2.hashCode());
        }
    }

    @Test
    void testNotEqualsHashCode() {
        for (int i = 0; i < 100; i++) {
            PersonEntity personEntity1 = new PersonEntity((long) i, "test" + i, "+79999999999");
            PersonEntity personEntity2 = new PersonEntity((long) (i + 1), "test" + i, "+79999999999");

            assertNotEquals(personEntity1.hashCode(), personEntity2.hashCode());
        }
    }

    @Test
    void testToString() {
        for (int i = 0; i < 100; i++) {
            PersonEntity personEntity = new PersonEntity((long) i, "test" + i, "+79999999999");
            assertEquals("PersonEntity(id=" + i + ", name=test" + i + ")", personEntity.toString());
        }
    }
}