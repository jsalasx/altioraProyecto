package drk.apps.infrastructure.request.purchaseOrder;

import drk.apps.infrastructure.models.Article;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ArticleRequest {

        @Min(value = 1,message = "El id del articulo no puede estar vacio")
        public Long id;

        @NotBlank(message = "name is mandatory and cannot be empty")
        public String name;

        @NotNull(message = "El precio no debe estar vacio")
        @DecimalMin(value = "0", message = "El precio debe ser mayor o igual a 0")
        public float price;

        @DecimalMin(value = "0", message = "El impuesto debe ser mayor o igual a 0")
        public float tax;

        public static Article toEntity(drk.apps.infrastructure.request.article.CreateArticleRequest request) {
            return new Article(request.name, request.price,request.tax);
        }
    }


