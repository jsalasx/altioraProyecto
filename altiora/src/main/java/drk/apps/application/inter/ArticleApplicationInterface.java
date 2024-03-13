package drk.apps.application.inter;

import drk.apps.infrastructure.models.Article;
import java.util.Set;

public interface ArticleApplicationInterface {
    public Article save(Article dataToSave);
    public Set<Article> getAll();
}
