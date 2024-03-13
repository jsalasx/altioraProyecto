package drk.apps.infrastructure.request.purchaseOrder;

import drk.apps.infrastructure.models.Article;
import drk.apps.infrastructure.models.Client;
import drk.apps.infrastructure.models.OrderDetail;
import drk.apps.infrastructure.models.PurchaseOrder;
import drk.apps.infrastructure.request.validation.FutureLocalDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CreatePurchaseOrderRequest {

    @Min(value = 1,message = "El id de cliente no puede estar vacio")
    public Long clientId;

    @Valid
    public ClientRequest client;

    @Valid
    public List<OrderDetailRequest> orderDetail;

    @NotBlank(message = "description no debe estar vacio")
    public String description;

    @DecimalMin(value = "0", message = "El total debe ser mayor o igual a 0")
    public float total;

    @DecimalMin(value = "0", message = "El impuesto debe ser mayor o igual a 0")
    public float taxes;

    @DecimalMin(value = "0", message = "El subtotal debe ser mayor o igual a 0")
    public float subtotal;

    @NotNull
    @FutureLocalDateTime
    public LocalDateTime createdAt;

    @NotNull
    @FutureLocalDateTime(message= " La fecha no puede esta vacia")
    public LocalDateTime updatedAt;

    public static PurchaseOrder toEntity (CreatePurchaseOrderRequest request) {
        Client client = new Client(request.client.id,request.client.name,request.client.identification,
                request.client.address,request.client.telephone);
        if (request.orderDetail.size() > 0) {
            Set<OrderDetail> listDetail = request.orderDetail.stream().map(detail -> {
                Article article = new Article(detail.article.id,detail.article.name,
                        detail.article.price,detail.article.tax);
                OrderDetail orderDetail = new OrderDetail(article,detail.quantity,detail.unitPrice,detail.totalPrice);
                return orderDetail;
            }).collect(Collectors.toSet());
            return new PurchaseOrder(client,listDetail,request.description,request.total,request.taxes,request.subtotal,request.createdAt,request.updatedAt);
        }
        return new PurchaseOrder(client,null,request.description,request.total,request.taxes,request.subtotal,request.createdAt,request.updatedAt);
    }
}
