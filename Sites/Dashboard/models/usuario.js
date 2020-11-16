'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
	let Usuario = sequelize.define('tecnico', {
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
	},
		{
			tableName: 'tecnico',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});

	return Usuario;
};
