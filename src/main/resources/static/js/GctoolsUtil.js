class GctoolsUtil {
	constructor() {
		this.appContext = "/gctools";
	}
	
	appendSpinner(element) {
		if(element) {
			$(element).append("<span class='spinner spinner-border spinner-border-sm' role='status' aria-hidden='true'>");
		}
	}
	
	removeSpinner(element) {
		if(element) {
			let $spinner = $(element).find("span.spinner");
			if($spinner.length > 0) {
				$spinner.remove();
			}
		}
	}
	
	postJson(urlEndpoint, data, expectedDataType, callbackOnSuccess, callbackOnFail, callbackAlways) {
		try {
			$.ajax({
				type: "POST",
				contentType: 'application/json',
				url: urlEndpoint,
				data: JSON.stringify(data),
				dataType: expectedDataType ? expectedDataType : "json"
			})
			.done((response) => {
				if(callbackOnSuccess) {
					callbackOnSuccess(response);
				}
			})
			.fail((error) => {
				if(callbackOnFail) {
					callbackOnFail(error);
				} else {
					console.error("GctoolsUtil.postJson fail. Error:", error);
				}
			})
			.always(() => {
				if(callbackAlways) {
					callbackAlways();
				}
			});		
		} catch(e) {
			console.log("GctoolsUtil.postJson fail.", e);
		}
	}
}