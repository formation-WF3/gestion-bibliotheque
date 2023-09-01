package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.CategoryModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookAdapterTest {
    private final BookAdapter bookAdapter = new BookAdapter();

    @Nested
    @DisplayName("Tests de la méthode BookAdapter::toModel")
    class ToModel {
        @Test
        void doitRetournerNullQuandUnDtoNullEstPasseEnParametre() {
            // given => ici on fait toutes les initialisations

            // when => ici on fait appel à la fonction qu'on veut tester
            BookModel model = bookAdapter.toModel(null, null);

            // then => ici on fait tous les tests (asserts)
            assertNull(model);
        }

        @Test
        void doitRetournerUnBookModelNonNull() {
            // given
            BookDto bookDto = BookDto.builder()
                    .id(1L)
                    .title("title")
                    .author("auteur")
                    .totalItems(5)
                    .remainingItems(2)
                    .categoryName("Science")
                    .build();
            CategoryModel categoryModel = CategoryModel.builder()
                    .id(1)
                    .name("Science")
                    .build();

            // when
            BookModel bookModel = bookAdapter.toModel(bookDto, categoryModel);

            // then
            assertEquals(bookDto.getId(), bookModel.getId());
            assertEquals(bookDto.getTitle(), bookModel.getTitle());
            assertEquals(bookDto.getAuthor(), bookModel.getAuthor());
            assertEquals(bookDto.getTotalItems(), bookModel.getTotalItems());
            assertEquals(bookDto.getRemainingItems(), bookModel.getRemainingItems());
            assertNotNull(bookModel.getCategory());

            // on teste la catégorie
            assertEquals(bookModel.getCategory().getId(), categoryModel.getId());
            assertEquals(bookModel.getCategory().getName(), categoryModel.getName());
        }
    }

    @Nested
    @DisplayName("Tests de la méthode BookAdapter::toDto")
    class ToDto {
        // ToDo
    }
}
