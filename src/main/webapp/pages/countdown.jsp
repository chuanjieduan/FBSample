<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- <link href="/css/bootstrap.css" type="text/css" rel="stylesheet" /> -->
	<link href="/css/formCss.css" type="text/css" rel="stylesheet" />
	<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" type="text/css" rel="stylesheet">
	<link href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" media="screen">
	
	<script src="/js/jquery-1.8.3.min.js" type="text/javascript"></script>
	<!-- <script src="/js/bootstrap.min.js" type="text/javascript"></script> -->
	<script src="/js/fb.js" type="text/javascript"></script>
</head>
<body>
	<form class="jotform-form" action="" method="post"
		accept-charset="utf-8">
		<div class="form-all">
			<ul class="form-section">
				<li id="cid_24" class="form-input-wide" data-type="control_head">
					<div class="form-header-group">
						<div class="header-text httal htvam">
							<h2 id="header_24" class="form-header">Add New Ctrip</h2>
						</div>
					</div>
				</li>
				<li class="form-line" data-type="control_textbox" id="id_29"><label
					class="form-label form-label-left form-label-auto" id="label_29"
					for="input_29"> Country: <span class="form-required">
							* </span>
				</label>
					<div id="cid_29" class="form-input-wide ">
						<select class="form-list select" name="country" onchange="loadArea()" id="country">
							<option class="option">Select country</option>
							<c:forEach items="${countries}" var="country">
								<option class="option" value="${country.id}">${country.name}</option>
							</c:forEach>
						</select>
					</div></li>
				<li class="form-line" data-type="control_textbox" id="id_25"><label
					class="form-label form-label-left form-label-auto" id="label_25"
					for="input_25"> Area: <span class="form-required"> *
					</span>
				</label>
					<div id="cid_25" class="form-input-wide ">
						<select class="form-list select" name="area" id="area" onchange="loadResort()">
							<option class="option">Select area</option>
						</select>
					</div></li>
				<li class="form-line" data-type="control_email" id="id_30"><label
					class="form-label form-label-left form-label-auto" id="label_30"
					for="input_30"> Resort: <span class="form-required">
							* </span>
				</label>
					<div id="cid_30" class="form-input-wide ">
						<select class="form-list select" name="resort" id="resort">
							<option class="option">Select resort</option>
						</select>
					</div></li>
				<li class="form-line  allowTime" data-type="control_datetime" id="id_26">
					<label class="form-label form-label-left form-label-auto" id="label_26"
					for="input_26"> Start date: 
					<span class="form-required"> * </span>
					</label>
					<div id="startdate" class="input-append date">
						<input type="text"></input> <span class="add-on"> <i
							data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
						</span>
					</div>
					
				</li>
				<li class="form-line  allowTime" data-type="control_datetime"
					id="id_40"><label
					class="form-label form-label-left form-label-auto" id="label_40"
					for="input_40"> End date: <span class="form-required">
							* </span>
				</label>
				<div id="enddate" class="input-append date">
						<input type="text"></input> <span class="add-on"> <i
							data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
						</span>
					</div></li>
				<li class="form-line" data-type="control_button" id="id_32">
					<div id="cid_32" class="form-input-wide">
						<div style="margin-left: 156px" class="form-buttons-wrapper">
							<button id="input_32" type="submit" class="form-submit-button">
								Submit</button>
						</div>
					</div>
				</li>
			</ul>
			<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
			</script>
			<script type="text/javascript" src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
			</script>
			<script type="text/javascript" src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
			</script>
			<script type="text/javascript">
				$('#startdate').datetimepicker({
					format : 'MM/dd/yyyy hh:mm',
					language : 'en',
					pickDate : true,
					pickTime : true,
					hourStep : 1,
					minuteStep : 15,
					secondStep : 30,
					inputMask : true
				});
				$('#enddate').datetimepicker({
					format : 'MM/dd/yyyy hh:mm',
					language : 'en',
					pickDate : true,
					pickTime : true,
					hourStep : 1,
					minuteStep : 15,
					secondStep : 30,
					inputMask : true
				});
			</script>
		</div>
		<input type="hidden" name="user" value="${user}" />
	</form>

	<div class="form-all">
		<ul class="form-section">
			<li id="cid_24" class="form-input-wide" data-type="control_head">
				<div class="form-header-group">
					<div class="header-text httal htvam">
						<h2 id="header_24" class="form-header">FRIENDS</h2>
					</div>
				</div>
			</li>
			<li class="form-line" data-type="control_textbox" id="id_29"><label
				class="form-label form-label-left form-label-auto" id="label_29"
				for="input_29"> Linda will travel to Mamora Bay in 132 days </label>
				<div class="fb-share-button"
					data-href="http://www.viawebtour.sk/Vyhladavanie/Afganistan/Balkh/?id_Oblast=3093&id_Stat=231&id_Stredisko=8301"
					data-layout="button"></div></li>
		</ul>
	</div>

	<div id="fb-root"></div>
	<div align="left" style="margin: 15px 0px 0px;">
		<div align="center"
			style="width: 140px; border: 1px solid rgb(204, 204, 204); text-align: center; color: rgb(19, 4, 5); font-weight: bold; font-size: 12px;">
			<a href="http://mycountdown.org/Special_Day/Anniversary/"
				style="text-decoration: none; font-size: inherit; color: rgb(19, 4, 5);"></a>
		</div>
		<script type="text/javascript"
			src="http://mycountdown.org/countdown.php?cp2_Hex=&cp1_Hex=130405&img=&hbg=&fwdt=210&lab=0&ocd=Anniversary&text1=travel Mamora Bay&text2=&group=Special Day&countdown=Anniversary&widget_number=3010&event_time=14451082&timezone=UTC&rep=4"></script>
	</div>

	<script type="text/javascript">
	function loadArea() {
		var countryid = $("#country").val();
		$.ajax({
			url:"/area/"+countryid,
			success :function (data){
				var serviceHtml = "<option class=\"option\">Select area</option>";
				$(data).each(function(index){
					serviceHtml += "<option class=\"option\" value=\""+this.id+"\">"+this.name+"</option>";
				});
				$("#area").html(serviceHtml);
			},error:function (){
		}});
	}
	
	function loadResort() {
		var areaid = $("#area").val();
		$.ajax({
			url:"/resort/"+areaid,
			success :function (data){
				var serviceHtml = "<option class=\"option\">Select resort</option>";
				$(data).each(function(index){
					serviceHtml += "<option class=\"option\" value=\""+this.link+"\">"+this.name+"</option>";
				});
				$("#resort").html(serviceHtml);
			},error:function (){
		}});
	}
	</script>
</body>
</html>