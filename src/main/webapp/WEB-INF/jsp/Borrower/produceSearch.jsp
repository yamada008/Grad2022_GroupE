<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>イチから始める農業</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-light bg-light static-top">
            <div class="container">
                <a class="navbar-brand" href="/SotsukenE/landNext">イチから始める農業</a>
            </div>
        </nav>
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
        <%-- AdviseServlet.javaへ値を送る --%>
        	<form action="/SotsukenE/advise" method="get" class="form-subscribe" id="contactForm" data-sb-form-api-token="API_TOKEN">
        		<input type="hidden" name="id" value="${id }">
        		<div class="row">
        			<div class=col>
        				<div class="col-auto">
        					開始日<br><input type="date" name="start_date" min="2023-01-01" max="2023-12-31"><br>
        					<p>おすすめテンプレート</p>
        					<label><input type="radio" name="type" value="ぐーたら" >同時に同じ作業を行う</label><br>
        					<label><input type="radio" name="type" value="よくばり" >同時に違う作業を行う</label><br>
        					<label><input type="radio" name="type" value="せっかち" >1年の間に複数の作物を同じ畑で育てる</label><br>
        					<p><input type="submit" value="選択"></p>
        				</div>
        			</div>
        		</div>
        	</form>
        </section>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>