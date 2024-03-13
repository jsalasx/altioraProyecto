package drk.apps.infrastructure.controllers;

import drk.apps.application.services.ArticleUseCase;
import drk.apps.application.services.ClientUseCase;
import drk.apps.infrastructure.models.Article;
import drk.apps.infrastructure.models.Client;
import drk.apps.infrastructure.request.article.CreateArticleRequest;
import drk.apps.infrastructure.request.client.CreateClientRequest;
import drk.apps.infrastructure.response.ResponseDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.validator.cdi.internal.interceptor.MethodValidated;

import java.util.Set;

@Path("v1/articles")
@MethodValidated
public class ArticleController {

    @Inject
    Validator validator;
    @Inject
    ArticleUseCase useCase;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDto<Set<Article>> getAll() {
        return new ResponseDto<Set<Article>>(useCase.getAll(),"",null);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDto<Article> saveArticle (@Valid CreateArticleRequest request) {
        Article resp = useCase.save(CreateArticleRequest.toEntity(request));
        return new ResponseDto<Article>(resp,"",null);
    }
}
