var Brewer = Brewer || {};

Brewer.CidadeCadastroRapido = (function() {
	
	function CidadeCadastroRapido() {
		this.modal = $('#modalCadastroRapidoCidade');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-cidade-salvar-btn');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
		this.inputNomeCidade = $('#nomeCidade');
		this.inputNomeEstado = $('#nomeEstado');
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-cidade');
	}
	
	CidadeCadastroRapido.prototype.iniciar = function() {
		this.form.on('submit', function(event) { event.preventDefault() });
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this))
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
	}
	
	function onModalShow() {
		this.inputNomeCidade.focus();
		
	}
	
	function onModalClose() {
		this.inputNomeCidade.val('');
		this.inputNomeEstado.val('')
		this.containerMensagemErro.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
	}
	
	function onBotaoSalvarClick() {
		var nomeCidade = this.inputNomeCidade.val().trim();
		var nomeEstado = this.inputNomeEstado.val().trim();
		console.log("nome cidade", nomeCidade);
		console.log("nome estado", nomeEstado);
		$.ajax({
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome: nomeCidade, estadoa: nomeEstado }),
			error: onErroSalvandoCidade.bind(this),
			success: onCidadeSalvo.bind(this)
		});
	}
	
	
	
	function onErroSalvandoCidade(obj) {
		var mensagemErro = obj.responseText;
		this.containerMensagemErro.removeClass('hidden');
		this.containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		this.form.find('.form-group').addClass('has-error');
	}
	
	function onCidadeSalvo(estilo) {
		var comboCidade = $('#cidade');
		comboCidade.append('<option value=' + cidade.codigo + '>' + cidade.nome + '</option>');
		comboCidade.val(cidade.codigo);
		this.modal.modal('hide');
	}
	
	return CidadeCadastroRapido;
	
}());

$(function() {
	var cidadeCadastroRapido = new Brewer.CidadeCadastroRapido();
	cidadeCadastroRapido.iniciar();
});



/// modo com designer pattern
//$(function() {
//	
//	var modal = $('#modalCadastroRapidoEstilo');
//	var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');
//	var form = modal.find('form');
//	form.on('submit', function(event) { event.preventDefault() });
//	var url = form.attr('action');
//	var inputNomeEstilo = $('#nomeEstilo');
//	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');
//	
//	modal.on('shown.bs.modal', onModalShow);
//	modal.on('hide.bs.modal', onModalClose)
//	botaoSalvar.on('click', onBotaoSalvarClick);
//	
//	function onModalShow() {
//		inputNomeEstilo.focus();
//	}
//	
//	function onModalClose() {
//		inputNomeEstilo.val('');
//		containerMensagemErro.addClass('hidden');
//		form.find('.form-group').removeClass('has-error');
//	}
//	
//	function onBotaoSalvarClick() {
//		var nomeEstilo = inputNomeEstilo.val().trim();
//		$.ajax({
//			url: url,
//			method: 'POST',
//			contentType: 'application/json',
//			data: JSON.stringify({ nome: nomeEstilo }),
//			error: onErroSalvandoEstilo,
//			success: onEstiloSalvo
//		});
//	}
//	
//	function onErroSalvandoEstilo(obj) {
//		var mensagemErro = obj.responseText;
//		containerMensagemErro.removeClass('hidden');
//		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
//		form.find('.form-group').addClass('has-error');
//	}
//	
//	function onEstiloSalvo(estilo) {
//		var comboEstilo = $('#estilo');
//		comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>');
//		comboEstilo.val(estilo.codigo);
//		modal.modal('hide');
//	}
//	
//});
