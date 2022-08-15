const book = {
  
  handleEvent(e) {
    const id = e.currentTarget.dataset.id;
    const layerDim = document.createElement("div");
    layerDim.id = "layer_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "update?id=" + id);
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer, #layer_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
};

const add = {
	handleEvent() {
    const layerDim = document.createElement("div");
    layerDim.id = "layer_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "add");
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer, #layer_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};

const student = {
	handleEvent() {
	    const layerDim = document.createElement("div");
	    layerDim.id = "layer_dim";
	    document.body.appendChild(layerDim);
	    layerDim.addEventListener("click", this.close);

	    const layer = document.createElement("div");
	    layer.id = "layer";
	    document.body.appendChild(layer);

	    const xhr = new XMLHttpRequest();
	    xhr.open("GET", "stAdd");
	    xhr.addEventListener("readystatechange", function() {
	        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
	            layer.innerHTML = xhr.responseText;
	          }
    	 });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer, #layer_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};

const studentList = {
	handleEvent() {
    const layerDim = document.createElement("div");
    layerDim.id = "layer_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "stList");
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer, #layer_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};


const rentalList = {
	handleEvent() {
    const layerDim = document.createElement("div");
    layerDim.id = "rental_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer_rental";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "rentalList");
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer_rental, #rental_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};

const solo = {
	handleEvent() {
	
	const test = document.getElementById("soloNm").value;
    const layerDim = document.createElement("div");
    layerDim.id = "rental_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer_rental";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "soloList?soloNm=" + test);
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer_rental, #rental_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};

const rental = {
  
  handleEvent(e) {
    const id = e.currentTarget.dataset.id;
    const layerDim = document.createElement("div");
    layerDim.id = "layer_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "rental?rentalNum=" + id);
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer, #layer_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
};

const returnBook = {
	handleEvent() {
	
    const layerDim = document.createElement("div");
    layerDim.id = "rental_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer_rental";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "return");
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer_rental, #rental_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};

const searchBook = {
	handleEvent() {
	const select = document.getElementById("select").value;
	const searchText = document.getElementById("searchText").value;
    const layerDim = document.createElement("div");
    layerDim.id = "rental_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer_rental";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "search?select=" + select + "&bookNm=" + searchText);
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer_rental, #rental_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};

const deleteBook = {
	handleEvent() {
    const layerDim = document.createElement("div");
    layerDim.id = "rental_dim";
    document.body.appendChild(layerDim);
    layerDim.addEventListener("click", this.close);

    const layer = document.createElement("div");
    layer.id = "layer_rental";
    document.body.appendChild(layer);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "delete");
    xhr.addEventListener("readystatechange", function() {
        if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
            layer.innerHTML = xhr.responseText;
          }
     });
     xhr.send(null);
    },

    close() {
      const els = document.querySelectorAll("#layer_rental, #rental_dim");
      for (el of els) {
          el.parentElement.removeChild(el);
      }
  }
	
};


window.addEventListener("DOMContentLoaded", function() {
  const editEls = document.getElementsByClassName("edit");
  for(el of editEls) {
    el.addEventListener("click", book);
  }
  const addBtn = document.getElementById("add");
  addBtn.addEventListener("click", add);
  
  const stBtn = document.getElementById("stAdd");
  stBtn.addEventListener("click", student);
  
  const stListBtn = document.getElementById("stList");
  stListBtn.addEventListener("click", studentList);
  
  const rentalBtn = document.getElementById("rentalList");
  rentalBtn.addEventListener("click", rentalList);
  
  const serBtn = document.getElementById("soloList");
  serBtn.addEventListener("click", solo);
  
  const renBtn = document.getElementsByClassName("rentalBtn");
  for(el of renBtn) {
	el.addEventListener("click", rental);
	}
	
  const returnBtn = document.getElementById("return");
  returnBtn.addEventListener("click", returnBook);
  
  const selectBtn = document.getElementById("select");
  selectBtn.addEventListener("change", function(e) {
	const search = document.getElementById("searchText");
	if(e.target.value == 'bookNm') {
		search.setAttribute("placeholder", "책 제목을 입력해주세요.");
	} else if(e.target.value == 'publisher') {
		search.setAttribute("placeholder", "책 출판사를 입력해주세요.");
	} else if(e.target.value == 'author') {
		search.setAttribute("placeholder", "책 저자를 입력해주세요.");
	}
	
	});

  const searchBtn = document.getElementById("searchBtn");
  searchBtn.addEventListener("click", searchBook);
  
  const deleteBtn = document.getElementById("delete");
  deleteBtn.addEventListener("click", deleteBook);

});