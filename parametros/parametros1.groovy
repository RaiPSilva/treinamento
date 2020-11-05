import org.boon.Boon;
import java.io.File;

def jsonFileName = "${JSONFILENAME}"
def jsonFile = new File(jsonFileName)
def jsonStartVal = "{}"
if (jsonFile.exists()) {
	jsonStartVal = jsonFile.text
}
 
def jsonEditorOptions = Boon.fromJson(/{
	disable_edit_json: true,
	disable_properties: true,
	no_additional_properties: true,
	disable_collapse: true,
	disable_array_add: false,
	disable_array_delete: false,
	disable_array_reorder: false,
	theme: "bootstrap2",
	iconlib:"fontawesome",
	schema: {
		"type": "object",
		"title": "Parametros",
		"properties": {
			"versao": {
				"title": "Versao do Aplicativo:",
				"type": "string",
				"maxLength": 10,
				"readOnly": "true",
				"propertyOrder" : 1
			},
			"codRegistro": {
				"title": "Numero de Registro:",
				"type": "string",
				"propertyOrder" : 2
			},
			"deployProducao": {
				"title": "Deploy em Producao:",
				"type": "string",
				"default": "SIM",
				"enum": ["SIM", "NAO"],
				"propertyOrder" : 3
			},
			"dataInicio": {
				"title": "Data Inicio:",
				"type": "string",
				"format": "date",
				"propertyOrder" : 4
			},
			"horaInicio": {
				"title": "Hora Inicio:",
				"type": "string",
				"format": "time",
				"propertyOrder" : 5
			},
			"dataFinal": {
				"title": "Data Final:",
				"type": "string",
				"format": "date",
				"propertyOrder" : 6
			},
			"horaFinal": {
				"title": "Hora Final:",
				"type": "string",
				"format": "time",
				"propertyOrder" : 7
			},
			"envioRelatorio": {
				"title": "Enviar Relatorio:",
				"type": "string",
				"default": "SIM",
				"enum": ["SIM", "NAO"],
				"propertyOrder" : 8
			},
			"pacotes": {
				"type": "array",
				"title": "Pacotes",
				"format": "tabs",
				"propertyOrder" : 9,
				"items": {
					"title": "Pacote",
					"type": "object",
					"properties": {
						"caminho": {
							"title": "Caminho do Pacote:",
							"type": "string",
							"propertyOrder" : 1
						},
						"sistema": {
							"title": "Sistema:",
							"type": "string",
							"enum": ["Sistema 1", "Sistema 2", "Sistema 3", "Sistema 4", "Sistema 5"],
							"propertyOrder" : 2
						},
					},
					"required": ["caminho", "sistema"]
				}
			}
		},
		"required": ["versao", "codRegistro", "deployProducao", "dataInicio", "horaInicio", "dataFinal", "horaFinal", "envioRelatorio", "pacotes"]
	},
	startval: ${jsonStartVal}
}/);

return jsonEditorOptions;