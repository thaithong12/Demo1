<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="tab3" class="tab-pane fade in">
	<div class="row">
		<!-- Rating -->
		<div class="col-md-3">
			<div id="rating">
				<div class="rating-avg">
					<span>4.5</span>
					<div class="rating-stars">
						<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star"></i> <i class="fa fa-star"></i> <i
							class="fa fa-star-o"></i>
					</div>
				</div>
				<ul class="rating">
					<li>
						<div class="rating-stars">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="rating-progress">
							<div style="width: 80%;"></div>
						</div> <span class="sum">3</span>
					</li>
					<li>
						<div class="rating-stars">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star-o"></i>
						</div>
						<div class="rating-progress">
							<div style="width: 60%;"></div>
						</div> <span class="sum">2</span>
					</li>
					<li>
						<div class="rating-stars">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i
								class="fa fa-star-o"></i>
						</div>
						<div class="rating-progress">
							<div></div>
						</div> <span class="sum">0</span>
					</li>
					<li>
						<div class="rating-stars">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
								class="fa fa-star-o"></i>
						</div>
						<div class="rating-progress">
							<div></div>
						</div> <span class="sum">0</span>
					</li>
					<li>
						<div class="rating-stars">
							<i class="fa fa-star"></i> <i class="fa fa-star-o"></i> <i
								class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
								class="fa fa-star-o"></i>
						</div>
						<div class="rating-progress">
							<div></div>
						</div> <span class="sum">0</span>
					</li>
				</ul>
			</div>
		</div>
		<!-- /Rating -->

		<!-- Reviews -->
		<div class="col-md-6">
			<div id="reviews">
				<ul class="reviews">
					<c:forEach items="${comments}" var="cmt">
						<li>
							<div class="review-heading">
								<h5 class="name">${cmt.accountEntity.email }</h5>
								<p class="date">${cmt.commentDate }</p>
								<c:forEach items="${votes}" var="vote">
									<c:if test="${vote.accountEntity.id == cmt.accountEntity.id }">
										<c:forEach begin="1" end="${vote.vote}" step="1">
											<i class="fa fa-star"></i>
										</c:forEach>
										
									</c:if>
									
								</c:forEach>
								
									 
								</div>
							</div>
							<div class="review-body">
								<p>${cmt.content}</p>
							</div>
						</li>
					</c:forEach>
				</ul>
				<ul class="reviews-pagination">
					<li class="active">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
				</ul>
			</div>
		</div>
		<!-- /Reviews -->

		<!-- Review Form -->
		<div class="col-md-3">
			<div id="review-form">
				<form class="review-form">
					<input class="input" type="text" placeholder="Your Name"> <input
						class="input" type="email" placeholder="Your Email">
					<textarea class="input" placeholder="Your Review"></textarea>
					<div class="input-rating">
						<span>Your Rating: </span>
						<div class="stars">
							<input id="star5" name="rating" value="5" type="radio"><label
								for="star5"></label> <input id="star4" name="rating" value="4"
								type="radio"><label for="star4"></label> <input
								id="star3" name="rating" value="3" type="radio"><label
								for="star3"></label> <input id="star2" name="rating" value="2"
								type="radio"><label for="star2"></label> <input
								id="star1" name="rating" value="1" type="radio"><label
								for="star1"></label>
						</div>
					</div>
					<button class="primary-btn">Submit</button>
				</form>
			</div>
		</div>
		<!-- /Review Form -->
	</div>
</div>