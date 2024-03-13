package drk.apps.infrastructure.request.purchaseOrder;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

public class OrderDetailRequest {

    @Min(value = 1,message = "El id del articulo no puede estar vacio")
    public Long articleId;

    @Valid
    public ArticleRequest article;

    @DecimalMin(value = "0.01", message = "La cantidad precio debe ser mayor 0")
    public float quantity;

    @DecimalMin(value = "0", message = "El precio untario debe ser mayor o igual a 0")
    public float unitPrice;

    @DecimalMin(value = "0", message = "El precio debe ser mayor o igual a 0")
    public float totalPrice;


}
