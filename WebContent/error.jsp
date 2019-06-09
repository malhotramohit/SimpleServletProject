<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<style>
@import
	url('https://fonts.googleapis.com/css?family=Roboto+Mono:300,500');

html, body {
	width: 100%;
	height: 100%;
}

body {
	background-image:
		url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/257418/andy-holmes-698828-unsplash.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	min-height: 100vh;
	min-width: 100vw;
	font-family: "Roboto Mono", "Liberation Mono", Consolas, monospace;
	color: rgba(255, 255, 255, .87);
}

.mx-auto {
	margin-left: auto;
	margin-right: auto;
}

.container, .container>.row, .container>.row>div {
	height: 100%;
}

#countUp {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100%; . number { font-size : 4rem;
	font-weight: 500;
	+
	.
	text
	{
	margin
	:
	0
	0
	1rem;
}

}
.text {
	font-weight: 300;
	text-align: center;
}
}
</style>

<script type="text/javascript">
<!--
	//-->

	var formatThousandsNoRounding = function(n, dp) {
		var e = '', s = e + n, l = s.length, b = n < 0 ? 1 : 0, i = s
				.lastIndexOf(','), j = i == -1 ? l : i, r = e, d = s.substr(
				j + 1, dp);
		while ((j -= 3) > b) {
			r = '.' + s.substr(j, 3) + r;
		}
		return s.substr(0, j + 3)
				+ r
				+ (dp ? ','
						+ d
						+ (d.length < dp ? ('00000').substr(0, dp - d.length)
								: e) : e);
	};

	var hasRun = false;

	inView('#countUp')
			.on(
					'enter',
					function() {
						if (hasRun == false) {
							$('.number')
									.each(
											function() {
												var $this = $(this), countTo = $this
														.attr('data-count');

												$({
													countNum : $this.text()
												})
														.animate(
																{
																	countNum : countTo
																},
																{
																	duration : 2000,
																	easing : 'linear',
																	step : function() {
																		$this
																				.text(formatThousandsNoRounding(Math
																						.floor(this.countNum)));
																	},
																	complete : function() {
																		$this
																				.text(formatThousandsNoRounding(this.countNum));
																	}
																});
											});
							hasRun = true;
						}
					});
</script>

<div class="container">
	<div class="row">
		<div class="xs-12 md-6 mx-auto">
			<div id="countUp">
				<div class="number" data-count="404">0</div>
				<div class="text">
					<%
						String msg = (String) request.getAttribute("errorString");
					%>
					<%=msg%>

				</div>
				<div class="text">Page not found</div>
				<div class="text">This may not mean anything.</div>
				<div class="text">I'm probably working on something that has
					blown up.</div>
			</div>
		</div>
	</div>
</div>
