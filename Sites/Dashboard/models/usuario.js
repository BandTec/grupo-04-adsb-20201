'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
	let Tecnico = sequelize.define('Tecnico', {
		id: {
			field: 'id',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		nomeTec: {
			field: 'nomeTec',
			type: DataTypes.STRING,
			allowNull: false
		},
		foneTec: {
			field: 'foneTec',
			type: DataTypes.STRING,
			allowNull: false
		},
		emailTec: {
			field: 'emailTec',
			type: DataTypes.STRING,
			allowNull: false
		},
		senhaTec: {
			field: 'senhaTec',
			type: DataTypes.STRING,
			allowNull: false
		},
		fkEscola: {
			field: 'fkEscola',
			type: DataTypes.INTEGER,
			allowNull: false
		},
	},
		{
			tableName: 'Tecnico',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

	return Tecnico;
};
