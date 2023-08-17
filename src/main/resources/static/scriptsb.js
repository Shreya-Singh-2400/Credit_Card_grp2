let ele=document.getElementById('cust')
function getCustomer() {
	//const url = "http://jcdemoopenshift1.conygre.com:8081/customer";
	alert('fetching customers')
	const url = "http://localhost:8080/customers";
	fetch(url)//promise object to return data from Rest API
		.then(function(response) {console.log(response); return response.json(); }) //resolve , data from resolve is passed to next then
		.then(function(Customers) {
		console.log(Customers);
			if (Customers.length > 0) {
				var temp = "";
				Customers.forEach(function (Customer) {
					temp += "<tr>";
					temp += "<td>" + Customer.customerId + "</td>";
					temp += "<td>" + Customer.firstName + "</td>";
					temp += "<td>" + Customer.lastName + "</td>";
					temp += "<td>" + Customer.gender + "</td>";
					temp += "<td>" + Customer.job + "</td>";
					temp += "<td>" + Customer.dob + "</td>";
					temp += "<td> <button onclick='populateInputs(" + Customer.customerId +
						")'>Edit</button>&nbsp;<button onClick='deleteCustomer(" +
						Customer.customerId + ")'>Delete</button ></td></tr>"

				});
				ele.innerHTML += temp;
                console.log(ele);
			}
		});
}

function addCustomer() {
alert('clicked')
	const data = {
		customerId:document.getElementById('customerId').value,
		name: document.getElementById('firstName').value,
		lastname: document.getElementById('lastName').value,
		gender: document.getElementById('gender').value,
		job: document.getElementById('job').value,
		dob: document.getElementById('dob').value
	};
	console.log(data);
	//const url = "http://jcdemoopenshift1.conygre.com:8081/Customer";
	const url = "http://localhost:8080/customers";
	fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	}).then(function(){
		document.getElementById('firstName').value = "";
		document.getElementById('lastName').value = "";
		document.getElementById('gender').value = "";
		document.getElementById('job').value = "";
		document.getElementById('dob').value = "";
		getCustomer();
	});
}

function populateInputs(_id) {
	//const url = `http://jcdemoopenshift1.conygre.com:8081/Customer/${id}`;
	const url = `/Customer/${_id}`;
	fetch(url)
		.then(function(response){ return response.json(); })
		.then(function(Customer){
			document.getElementById('customer_id').innerText = Customer.customer_id;
			document.getElementById('firstname').value = Customer.firstname;
			document.getElementById('lastname').value = Customer.firstname;
			document.getElementById('gender').value = Customer.gender;
			document.getElementById('job').value = Customer.job;
			document.getElementById('dob').value = Customer.dob;
			document.getElementById('save').disabled = false;
			document.getElementById('add').disabled = true;
		});
}

function saveCustomer() {
	const Customer = {
		id: document.getElementById('customer_id').innerText,
		firstname: document.getElementById('firstname').value,
		lastname: document.getElementById('lastname').value,
		gender: document.getElementById('gender').value,
		job: document.getElementById('job').value,
		dob: document.getElementById('dob').value
	};
	const id = document.getElementById('_id').innerText;
	const url = `/Customer/${_id}`;
	//const url = `http://jcdemoopenshift1.conygre.com:8081/Customer/${id}`;
	fetch(url, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(Customer)
	}).then( function(){
		document.getElementById('customer_id').innerText = "";
		document.getElementById('firstname').value = "";
		document.getElementById('lastname').value = "";
		document.getElementById('gender').value = "";
		document.getElementById('job').value = "";
		document.getElementById('dob').value = "";
		document.getElementById('save').disabled = true;
		document.getElementById('add').disabled = false;
		getCustomer();
	});
}

function deleteCustomer(customer_id) {
	const choice = confirm(`Do you want to delete the customer with id ${_id}?`);
	const url = `/Customer/${_id}`;
    //const url = `http://jcdemoopenshift1.conygre.com:8081/Customer/${id}`;
	if (choice == true) {
		fetch(url, {
			method: 'DELETE'
		}).then(function(response){
			alert(`The customer with id ${_id} has been deleted`);
			getCustomer();
		});
	}
}